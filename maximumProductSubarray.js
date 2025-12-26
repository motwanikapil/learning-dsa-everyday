function subarrayWithMaxProduct(arr) {
  let pre = 1;
  let suff = 1;

  let ans = Number.MIN_SAFE_INTEGER;
  let n = arr.length;

  for (let i = 0; i < n; i++) {
    if (pre == 0) pre = 1;
    if (suff == 0) suff = 1;

    pre = pre * arr[i];
    suff = suff * arr[n - i - 1];

    ans = Math.max(ans, pre, suff);
  }

  console.log(`value of ans is ${ans}`);
}

subarrayWithMaxProduct([2, 3, -2, 4]);
