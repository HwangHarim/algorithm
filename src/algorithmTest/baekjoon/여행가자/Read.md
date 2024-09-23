## 풀이 참조

---

> 혼자 풀이
>
> 1. 해당 경로가 가능한지를 알아보기 위해 DFS를 사용함
> 2. DFS의 루프를 걸러낼 조건이 없음
     >

1. Array[] 를 통해 경로 저장

> 2. 1 -> 3 까지 가야 할 때 중간에 어떤 수가 있어도 상관 없음 중복 허용(DFS를 적용하기 어려운 상황)
>    3. 전체를 조회하려 시도 -> 중복되는 경로를 어떻게 결과 순서대로 지나가는지 찾을 방법이 없음

---
> 해답
>  1. Union find 알고리즘으로 구현하기

```java
public int[] parent;

public static int find(int x) {
    if (parent[x] == x) {
        return x;
    }
    return parent[x] = find(parent[x]);
}

public static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }
}
```

> 2. 부모라는 Array를 사용해서 각 인덱스의 부모를 저장
> 3. 저장된 부모를 find() 로 비교해서 연결되어 있는지 확인하기

---

> 결론
>
> 모든 경로 문제를 dfs, bfs로 풀지 말자 중복되는 경로, 노드사이 여러 루트가 추가된다면 Union find 알고림즘을 고려해보자.