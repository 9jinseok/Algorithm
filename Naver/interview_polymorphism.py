class gun1:
    def __init__(self, bullet):
        self.bullet = bullet
    
    def shot(self):
        print("gun1 shot")
        self.bullet -= 1

class gun2:
    def __init__(self,bullet):
        self.bullet = bullet

    def shot(self):
        print("gun2 shot")
        self.bullet -= 1


if __name__ == "__main__":
    p = gun1(3)
    q = gun2(2)
    for i in (p,q):
        i.shot()