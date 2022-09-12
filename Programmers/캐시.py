def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5

    cities = [c.lower() for c in cities]
    answer = 0
    cache = []
    for city in cities:
        if city in cache:
            cache.pop(cache.index(city))
            cache.append(city)
            answer += 1
        else:
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                cache.pop(0)
                cache.append(city)
            answer += 5
    
    return answer