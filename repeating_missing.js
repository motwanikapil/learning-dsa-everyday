function findRepeatingMissingBrute(nums){
	// o(n2)
	let repeating = -1, missing = -1;
	for(let i=1 ; i <= nums.length ; i++) {
		let count = 0
		for(let j=0 ; j < nums.length ; j++) {
			if (arr[j] == i) {
				count++;
			}
		}
		if(count == 2) {
			repeating = i;
		} else if (count == 0) {
			missing = i;
		}
		if (repeating === -1 && missing === -1) {
			break;
		}
	}
	return [repeating, missing]
}

function findRepeatingMissingBetter(nums) {
	let n = nums.length;
	let hash = new Array(n+1).fill(0);

	for(let i=0 ; i < n ; i++) {
		hash[nums[i]]++;
	}
	let repeating = -1, missing = -1;

	for (let i=1 ; i <= n ; i++) {
		if (hash[i] == 2) repeating = i;
		else if (hash[i] == 0) missing = i;
		if (repeating == -1 && missing == -1) {
			break;
		}
	}

	return [repeating, missing];
}

function findRepeatingMissingOptimal1(nums) {
	let n = nums.length;
	let sN = (n * (n+1)) / 2; // sum of first n natural numbers
	let s2N = (n * (n+1) * (2 * n + 1)) / 6;
	let s = 0 , s2 = 0;
	for (let i=0 ; i < n ; i++) {
		s += a[i];
		s2 += a[i] * a[i];
	}
	let val1 = s - sN; // sum of array - sum of n natural numbers ( x - y )
	let val2 = s2 - s2N; // sum of squares of elements of array - sum of squares of n natural numbers ( x2 - y2 )

	val2 = val2 / val1;

	let x = (val1 + val2) / 2
	let y = x - val1
	return [x, y]
}

function findRepeatingMissingOptimal2(nums) {
	let n = nums.length;
	let xr = 0
	for(let i=0 ; i < n ; i++) {
		xr = xr ^ nums[i];
		xr = xr ^ (i + 1);
	}

	// let bitNo = 0;

	// while (true) {
	// 	if ( (xr & (1 << bitNo)) !== 0 ) break;

	// 	bitNo++;
	// }

	let number = xr & ~(xr - 1);

	let zero = 0;
	let one = 0;

	for (let i=0 ; i < n ; i++) {
		// part of 1th club
		// if ((nums[i] & (1 << bitNo)) !== 0) {
		if ((nums[i] & number) !== 0) {
			one = one ^ nums[i];
		}

		// part of 0th club
		else {
			zero = zero ^ nums[i];
		}
	}

	for (let i=1 ; i <= n ; i++) {
		// part of 1th club
		// if ((i & (1 << bitNo)) != 0) {
		if ((i & number) != 0) {
			one = one ^ i;
		}

		// part of 0th club
		else {
			zero = zero ^ i;
		}
	}

	let cnt = 0;
	for (let i=0 ; i < n ; i++) {
		if (nums[i] === zero) cnt++;
	}
	if (cnt === 2) return [zero, one];
	return [one, zero];
}

arr = [4, 3, 6, 2, 1, 1]
console.log(findRepeatingMissingOptimal2(arr))