import sys

class Queue:
    def __init__(self):
        self.arr = []
        self.size = 0
        
    def enqueue(self,value):
        self.arr.append(value)
        self.size += 1
    
    def dequeue(self):
        if self.size == 0:
            return 'no'
        else:
            self.size -= 1
            return self.arr.pop(0)
                    
    def getSize(self):
        return self.size
    
def bfs(n, m, edges, s):
    # Complete this function
    q1 = Queue()
    visited = [0]*n
    visited[s-1] = 1 
    q1.enqueue([s,0])
    distance = [-1]*n
    edge_flags = [0]*m
        
    while q1.getSize() != 0:
        node, level = q1.dequeue()
        distance[node-1] = level*6
        visited[node-1] = 1
        for i in range(m):
            if edge_flags[i] == 0:
                u,v = edges[i][0],edges[i][1]
                if node == u and visited[v-1] == 0:
                    visited[v-1] = 1
                    q1.enqueue([v,level+1])
                    edge_flags[i] = 1
                if node == v and visited[u-1] == 0:
                    visited[u-1] = 1
                    q1.enqueue([u,level+1])
                    edge_flags[i] = 1
    return distance[0:s-1]+distance[s:]
                 
    
if __name__ == "__main__":
    q = int(raw_input().strip())
    for a0 in xrange(q):
        n, m = raw_input().strip().split(' ')
        n, m = [int(n), int(m)]
        edges = []
        for edges_i in xrange(m):
            edges_temp = map(int,raw_input().strip().split(' '))
            edges.append(edges_temp)
        s = int(raw_input().strip())
        result = bfs(n, m, edges, s)
        print " ".join(map(str, result))