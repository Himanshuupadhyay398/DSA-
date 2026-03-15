class Fancy {

    int MOD = 1000000007;
    int MAX = 100000;

    long[] tree = new long[4 * MAX];
    long[] lazyMul = new long[4 * MAX];
    long[] lazyAdd = new long[4 * MAX];

    int size = 0;

    public Fancy() {
        Arrays.fill(lazyMul, 1);
    }

    void push(int node, int l, int r) {
        if (lazyMul[node] == 1 && lazyAdd[node] == 0) return;

        tree[node] = (tree[node] * lazyMul[node] % MOD +
                     (r - l + 1) * lazyAdd[node] % MOD) % MOD;

        if (l != r) {
            int left = node * 2;
            int right = node * 2 + 1;

            lazyMul[left] = lazyMul[left] * lazyMul[node] % MOD;
            lazyMul[right] = lazyMul[right] * lazyMul[node] % MOD;

            lazyAdd[left] = (lazyAdd[left] * lazyMul[node] + lazyAdd[node]) % MOD;
            lazyAdd[right] = (lazyAdd[right] * lazyMul[node] + lazyAdd[node]) % MOD;
        }

        lazyMul[node] = 1;
        lazyAdd[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr, long mul, long add) {
        push(node, l, r);

        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            lazyMul[node] = mul;
            lazyAdd[node] = add;
            push(node, l, r);
            return;
        }

        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr, mul, add);
        update(node * 2 + 1, mid + 1, r, ql, qr, mul, add);

        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    void pointUpdate(int node, int l, int r, int idx, int val) {
        push(node, l, r);

        if (l == r) {
            tree[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            pointUpdate(node * 2, l, mid, idx, val);
        else
            pointUpdate(node * 2 + 1, mid + 1, r, idx, val);

        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    long query(int node, int l, int r, int idx) {
        push(node, l, r);

        if (l == r) return tree[node];

        int mid = (l + r) / 2;

        if (idx <= mid)
            return query(node * 2, l, mid, idx);
        else
            return query(node * 2 + 1, mid + 1, r, idx);
    }

    public void append(int val) {
        pointUpdate(1, 0, MAX - 1, size, val);
        size++;
    }

    public void addAll(int inc) {
        update(1, 0, MAX - 1, 0, size - 1, 1, inc);
    }

    public void multAll(int m) {
        update(1, 0, MAX - 1, 0, size - 1, m, 0);
    }

    public int getIndex(int idx) {
        if (idx >= size) return -1;
        return (int) query(1, 0, MAX - 1, idx);
    }
}