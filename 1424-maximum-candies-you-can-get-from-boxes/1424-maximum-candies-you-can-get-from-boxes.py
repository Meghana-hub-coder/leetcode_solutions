from collections import deque

class Solution:
    def maxCandies(self, status, candies, keys, containedBoxes, initialBoxes):
        n = len(status)
        owned = set(initialBoxes)
        queue = deque()
        seen = set()
        
        for box in initialBoxes:
            if status[box] == 1:
                queue.append(box)
                seen.add(box)
        
        available_keys = set()
        total_candies = 0
        
        while queue:
            box = queue.popleft()
            total_candies += candies[box]
            
            # Add keys found in this box
            for key in keys[box]:
                if key not in available_keys:
                    available_keys.add(key)
                    # If we own this box and haven't opened it yet
                    if key in owned and key not in seen:
                        queue.append(key)
                        seen.add(key)

            # Add new boxes found inside this box
            for new_box in containedBoxes[box]:
                if new_box not in owned:
                    owned.add(new_box)
                if status[new_box] == 1 or new_box in available_keys:
                    if new_box not in seen:
                        queue.append(new_box)
                        seen.add(new_box)

        return total_candies

              