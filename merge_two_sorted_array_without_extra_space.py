def with_extra_space(nums1, nums2):
	nums3 = []

	left = 0
	right = 0

	n = len(nums1)
	m = len(nums2)

	index = 0

	while left < n and < right < m:
		if nums1[left] <= nums2[right]:
			nums3[index] = nums1[left];
			left += 1
		else:
			nums3[index] = nums2[right]
			right += 1
		index += 1

	while left < n:
		nums3[index] = nums1[left]
		left += 1
		index += 1

	while right < m:
		nums3[index] = nums2[right]
		right += 1
		index += 1

	for i in range(n+m):
		if i < n:
			nums1[i] = nums3[i]
		else:
			nums2[i-n] = nums3[i]

def optimal(nums1, nums2):
	n = len(nums1)
	m = len(nums2)
	left = n-1
	right = 0

	while left >= 0 and right < m:
		if nums1[left] > nums2[right]:
			nums1[left], nums2[right] = nums2[right], nums1[left]
			left -= 1
			right += 1
		else:
			break

	nums1.sort()
	nums2.sort()

def swap_if_greater(nums1, nums2, idx1, idx2):
	if nums1[idx1] > nums2[idx2]:
		nums1[idx1], nums2[idx2] = nums2[idx2], nums1[idx1]


def optimal2(nums1, nums2):
	n = len(nums1)
	m = len(nums2)

	t_len = (n + m)

	gap = (t_len // 2) + (t_len % 2)

	while gap > 0:
		left = 0
		right = left + gap

		while right < t_len:
			# left on left array and right on right array
			if left < n and right >= n:
				swap_if_greater(nums1, nums2, left, right - n)

			# left on right array
			elif left >= n:
				swap_if_greater(nums2, nums2, left - n, right - n)

			# both on array 1
			else:
				swap_if_greater(nums1, nums1, left, right)

			left += 1
			right += 1

		if gap == 1:
			break

		gap = (gap // 2) + (gap % 2)
