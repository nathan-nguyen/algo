def is_leap(year):
	# Write your logic here
	if year % 4 != 0 or (year % 100 == 0 and year % 400 != 0):
		return False
	return True
