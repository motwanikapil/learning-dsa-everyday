function merge(arr, low, mid, high) {
	temp = []
	left = low
	right = mid + 1
	let cnt = 0
	
	
	while (left <= mid && right <= high) {
		if (arr[left] <= arr[right]) {
			temp.push(arr[left])
			left++
		} else {
			temp.push(arr[right])
			cnt += (mid - left + 1)
			right++
		}
	}
	
	while (left <= mid) {
		temp.push(arr[left])
		left++
	}
	
	while (right <= high) {
		temp.push(arr[right])
		right++
	}
	
	for (let i=low ; i <= high ; i++) {
		arr[i] = temp[i - low]
	}
	
	return cnt
}

function mergeSort(arr, low, high) {
	let cnt = 0
	if (low >= high) return cnt
	let mid = (low + high ) / 2
	cnt += mergeSort(arr, low, mid)
	cnt += mergeSort(arr, mid+1, high)
	cnt += merge(arr, low, mid, high)
	return cnt
}

function numberOfInversions(arr, n) {
	return mergeSort(arr, 0, n-1)
}

arr = [5,3,2,1,4]
n = 5
console.log(numberOfInversions(arr, n))

// tell to the interviewer that this code will distort the original array but if you want I can create a copy of array and work on that ( plus point )


