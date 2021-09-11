def solution(nicks, emails):
    ans = []
    n = len(nicks)

    for l in range(n-1):
        for r in range(l+1,n):
            n1 = nicks[l]
            n2 = nicks[r]
            e1 = emails[l].split('@')
            e2 = emails[r].split('@')
            chk1 = False
            chk2 = False
            
            if len(n1) == len(n2):
                if n1 == n2:
                    chk1 = True
                else:
                    for i in range(len(n1)):
                        for j in range(len(n2)):
                            if n1[:i] + n1[i+1:] == n2[:j] + n2[j+1:]:
                                chk1 = True
                                break
            if not chk1 and len(n1) > len(n2):
                if len(n1) - 1 == len(n2):
                    for i in range(len(n1)):
                        if n1[:i] + n1[i+1:] == n2:
                            chk1 = True
                            break
                elif len(n1) - 2 == len(n2):
                    for i in range(len(n1)-1):
                        for j in range(i+1, len(n1)):
                            if n1[:i] + n1[i+1:j] + n1[j+1:] == n2:
                                chk1 = True
                                break
            if not chk1 and len(n1) < len(n2):
                if len(n2) - 1 == len(n1):
                    for i in range(len(n2)):
                        if n2[:i] + n2[i+1:] == n1:
                            chk1 = True
                            break
                elif len(n2) - 2 == len(n1):
                    for i in range(len(n2)-1):
                        for j in range(i+1, len(n2)):
                            if n2[:i] + n2[i+1:j] + n2[j+1:] == n1:
                                chk1 = True
                                break
            if not chk1:
                continue
            
            if e1[0] == e2[0]:
                chk2 = True
            
            if not chk2 and e1[1] == e2[1]:
                if len(e1[0]) - 1 == len(e2[0]):
                    for i in range(len(e1[0])):
                        if e1[0][:i] + e1[0][i+1:] == e2[0]:
                            chk2 = True
                            break
                elif len(e2[0]) - 1 == len(e1[0]):
                    for i in range(len(e2[0])):
                        if e2[0][:i] + e2[0][i+1:] == e1[0]:
                            chk2 = True
                            break
            
            if chk2:
                chk3 = False
                for i in range(len(ans)):
                    if l in ans[i] or r in ans[i]:
                        ans[i].append(l)
                        ans[i].append(r)
                        chk3 = True
                if not chk3:
                    ans.append([l,r])

    unique = 0
    for i in range(n):
        chk = False
        for j in range(len(ans)):
            if i in ans[j]:
                chk = True
        if not chk:
            unique +=1

    print(ans)
    return len(ans) + unique

print(solution(["imhero111", "moneyman", "hero111", "imher1111", "hro111", "mmoneyman", "moneymannnn"], ["superman5@abcd.com", "batman432@korea.co.kr", "superman@abcd.com", "supertman5@abcd.com", "superman@erty.net", "batman42@korea.co.kr", "batman432@usa.com"]))