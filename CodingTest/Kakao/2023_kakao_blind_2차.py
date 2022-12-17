import json
import requests

url = 'https://68ecj67379.execute-api.ap-northeast-2.amazonaws.com/api'
headers = {}

MAXDAY = 0
MAXROOM = 0
MAXLEN = 0
W = 0
H = 0
hotel_map = []


def start(qid=1):
    global headers
    params = {'problem': qid}
    headers = {
        'X-Auth-Token': 'b11eff1d4b4ea4ed7d01ee36e486e6e0',
        'Content-Type': 'application/json'
    }
    res = requests.post(url + '/start', headers=headers,
                        data=json.dumps(params))
    key = res.json()['auth_key']
    headers = {
        'Authorization': key,
        'Content-Type': 'application/json'
    }
    # print(key)
    global MAXDAY, MAXROOM, MAXLEN, W, H, hotel_map
    if (qid == 1):
        MAXDAY = 200
        MAXROOM = 10
        MAXLEN = 20
        W = 20
        H = 3
        # 가능한 날짜 * H * W 만큼의 boolean 3차원 배열
        hotel_map = [[[False] * (MAXDAY+1) for w in range(W)]
                     for _ in range(H)]
    else:
        MAXDAY = 1000
        MAXROOM = 50
        MAXLEN = 100
        W = 200
        H = 10
        hotel_map = [[[False] * (MAXDAY+1) for w in range(W)]
                     for _ in range(H)]


def use_GET(path):
    res = requests.get(url + path, headers=headers)
    print(res.json())
    return res.json()


def use_PUT(path, params):
    res = requests.put(url + path, headers=headers, data=json.dumps(params))
    # print(res.json())
    return res.json()


def toRoomNumber(h, w):
    ho = str(w + 1)
    while len(ho) < 3:
        ho = '0' + ho
    return str(h + 1) + ho


def toWH(roomNumber):
    return roomNumber % 1000 - 1, roomNumber // 1000 - 1


def isAvailable(amount, in_day, out_day):
    for i in range(H):
        for j in range(W - amount + 1):
            chk = True
            for k in range(j, j + amount):
                for d in range(in_day + 1, out_day + 1):
                    if (hotel_map[i][k][d]):
                        chk = False
                        break
                if (not chk):
                    break
            if (chk):
                return int(toRoomNumber(i, j))

    return 0


def KaKaoHotel(qid):
    start(qid)
    cnt = 0
    reservations_info = []
    accepted_info = []
    for day in range(1, MAXDAY):
        # 오늘 날짜로 만료한 애들 처리
        for i in range(len(reservations_info) - 1, -1, -1):
            if (reservations_info[i][4] < day):
                del reservations_info[i]

        # 새로 들어온 예약 정보 저장
        j = use_GET('/new_requests')

        for id, amount, in_day, out_day in ([i['id'], i['amount'], i['check_in_date'], i['check_out_date']] for i in j['reservations_info']):
            reservations_info.append(
                [id, amount, in_day, out_day, min(in_day - 1, day + 14), out_day - in_day])

        reservations_info = sorted(
            reservations_info, key=lambda x: (x[1], -x[5]))

        # 예약 정보 중 승인 가능 여부 판단 후 처리
        replies = []
        for i in range(len(reservations_info) - 1, -1, -1):
            r = reservations_info[i]
            accept = False
            refuse = False
            if (r[1] > MAXROOM*4/5):
                accept = True
            elif (r[1] > MAXROOM*3/5):
                if (r[5] < MAXLEN * 2/10):
                    accept = True
            elif (r[1] > MAXROOM*2/5):
                if (r[5] < MAXLEN * 1/10):
                    accept = True
            elif (r[1] > MAXROOM/5):
                if (r[5] >= MAXLEN * 9/10):
                    refuse = True
            else:
                if (r[5] >= MAXLEN * 8/10):
                    refuse = True

            if (not refuse and r[4] == day):
                accept = True

            if (accept or refuse):
                if (accept):
                    roomNumber = isAvailable(r[1], r[2], r[3])
                    if (roomNumber):
                        replies.append({'id': r[0], 'reply': 'accepted'})
                        accepted_info.append([r[0], r[2], roomNumber])
                        w, h = toWH(roomNumber)
                        for a in range(r[1]):
                            for d in range(r[2], r[3] + 1):
                                hotel_map[h][w + a][d] = True
                else:
                    replies.append({'id': r[0], 'reply': 'refused'})
                del reservations_info[i]

        params = {'replies': replies}
        use_PUT('/reply', params)

        # 오늘 날짜로 체크인 시킬 애들 싹 다 방 배정해주기
        room_assign = []
        for i in range(len(accepted_info) - 1, -1, -1):
            if day == accepted_info[i][1]:
                room_assign.append(
                    {'id': accepted_info[i][0], 'room_number': accepted_info[i][2]})
                del accepted_info[i]

        params = {'room_assign': room_assign}
        # print(params)
        j = use_PUT('/simulate', params)
        cnt += j['fail_count']

    use_PUT('/simulate', {'room_assign': []})
    # print('fail_count ' + str(cnt))
    use_GET('/score')


if __name__ == "__main__":
    KaKaoHotel(1)

    KaKaoHotel(2)
