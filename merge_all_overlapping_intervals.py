def merge_all_overlapping_intervals(nums):
	n = len(nums)
	nums.sort()
	ans = []

	for i in range(n):
		start = nums[i][0]
		end = nums[i][1]

		if not (len(ans) == 0) and end <= ans[-1][1]:
			continue

		for j in range(i+1, n):
			if nums[j][0] <= end:
				end = max(end, nums[j][1])
			else:
				break

		ans.append([start, end])

	return ans

def optimal(nums):
	n = len(nums)
	nums.sort()
	ans = []

	for i in range(n):
		if not len(ans) == 0 or nums[i][0] > ans[-1][1]:
			ans.append(nums[i])
		else:
			ans[-1][1] = max(ans[-1][1], nums[i][1])

	return ans

nums = [[1,3], [2,4], [3,5], [6,7]]

print('ans ', merge_all_overlapping_intervals(nums))