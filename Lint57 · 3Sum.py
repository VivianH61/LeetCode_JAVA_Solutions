    def three_sum(self, nums: List[int]) -> List[List[int]]:
        # write your code here
        if not nums:
            return []
        nums.sort()
        ans = []
        i = 0
        while i < len(nums) - 2:
            if nums[i] > 0:
                break
            l, r = i + 1, len(nums) - 1
            while l < r:
                while (l + 2 < r and nums[l] == nums[l + 2]):
                    l += 1
                while (r - 2 > l and nums[r - 2] == nums[r]):
                    r -= 1
                if nums[i] + nums[l] + nums[r] == 0:
                    if [nums[i], nums[l], nums[r]] not in ans:
                        ans.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                elif nums[i] + nums[l] + nums[r] > 0:
                    r -= 1
                else:
                    l += 1
            while i + 1 < len(nums) - 2 and nums[i + 1] == nums[i]:
                i += 1
            i += 1
        return ans
