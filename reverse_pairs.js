function merge(arr, low, mid, high) {
  temp = [];
  let left = low;
  let right = mid + 1;

  while (left <= mid && right <= high) {
    if (arr[left] <= arr[right]) {
      temp.push(arr[left]);
      left++;
    } else {
      temp.push(arr[right]);
      right++;
    }
  }

  while (left <= mid) {
    temp.push(arr[left]);
    left++;
  }

  while (right <= high) {
    temp.push(arr[right]);
    right++;
  }

  for (let i = low; i <= high; i++) {
    arr[i] = temp[i - low];
  }
}

function countPairs(arr, low, mid, high) {
  let right = mid + 1;
  let cnt = 0;

  for (let i = low; i <= mid; i++) {
    while (right <= high && arr[i] > 2 * arr[right]) right++;
    cnt += right - (mid + 1);
  }

  return cnt;
}

function mergeSort(arr, low, high) {
  let cnt = 0;
  if (low >= high) return cnt;
  let mid = (low + high) / 2;

  cnt += mergeSort(arr, low, mid);
  cnt += mergeSort(arr, mid + 1, high);
  cnt += countPairs(arr, low, mid, high);
  merge(arr, low, mid, high);
  return cnt;
}

function reversePairs(arr, n) {
  return mergeSort(arr, 0, arr.length - 1);
}

arr = [1, 3, 2, 3, 1];
console.log(`Number of reverse pairs : ${reversePairs(arr, 0, arr.length)}`); // we are distorting the array
