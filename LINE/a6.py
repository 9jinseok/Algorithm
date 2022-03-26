def solution(req_id, req_info):
    l = len(req_id)
    ans = dict()
    for r in req_id:
        ans[r] = [0,0]
    
    buy = []
    sell = []
    for i in range(l):
        type, amount, price = req_info[i]
        if type == 1:
            for j in range(len(buy)):
                if buy[j][2] >= price:
                    if buy[j][1] >= amount:
                        buy[j][1] -= amount
                        ans[buy[j][0]][0] += amount
                        ans[buy[j][0]][1] -= amount * price
                        ans[req_id[i]][0] -= amount
                        ans[req_id[i]][1] += amount * price
                        break
                    else:
                        amount -= buy[j][1]
                        ans[buy[j][0]][0] += buy[j][1]
                        ans[buy[j][0]][1] -= buy[j][1] * price
                        ans[req_id[i]][0] -= buy[j][1]
                        ans[req_id[i]][1] += buy[j][1] * price

                else:
                    break
            if amount > 0:
                sell.append([req_id[i], amount, price])
                sell.sort(key= lambda x : x[2])
        else:
            for j in range(len(sell)):
                if sell[j][2] <= price:
                    if sell[j][1] >= amount:
                        sell[j][1] -= amount
                        ans[sell[j][0]][0] -= amount
                        ans[sell[j][0]][1] += amount * sell[j][2]
                        ans[req_id[i]][0] += amount
                        ans[req_id[i]][1] -= amount * sell[j][2]
                        amount = 0
                        break
                    else:
                        amount -= sell[j][1]
                        ans[sell[j][0]][0] -= sell[j][1]
                        ans[sell[j][0]][1] += sell[j][1] * sell[j][2]
                        ans[req_id[i]][0] += sell[j][1]
                        ans[req_id[i]][1] -= sell[j][1] * sell[j][2]
                        sell[j][1] = 0
                else:
                    break
            if amount > 0:
                buy.append([req_id[i], amount, price])
                buy.sort(key= lambda x : x[2], reverse = True)
        
    ans = sorted(ans.items())
    res = []
    for a in ans:
        tmp = a[0]
        if a[1][0] > 0:
            tmp += " +" + str(a[1][0])
        else:
            tmp += " "+str(a[1][0])
        if a[1][1] > 0:
            tmp += " +" + str(a[1][1])
        else:
            tmp += " "+str(a[1][1])
        res.append(tmp)
    return res

print(solution(["Morgan", "Teo", "Covy", "Covy", "Felix"],[[0, 10, 50], [1, 35, 70], [0, 10, 30], [0, 10, 50], [1, 11, 40]]))