# implements 'substitution' operation using only 'addition'
def sub_using_add(a, b):
	return a + negate_using_add(b)

# implements 'multiplication' operation using only 'addition'
def mult_using_add(a, b):
	result = 0
	abs_a = my_abs(a)
	abs_b = my_abs(b)
	for i in range(0, abs_b):
		result += abs_a
	if (a > 0 and b > 0) or (a < 0 and b < 0):
		return result
	else:
		return negate_using_add(result)

# implements integer's 'division' operation using only 'addition'
def div_using_add(a, b):
	abs_a = my_abs(a)
	abs_b = my_abs(b)
	result = 0
	while abs_a >= 0:
		abs_a -= abs_b
		result += 1
	result -= 1
	if (a > 0 and b > 0) or (a < 0 and b < 0):
		return result
	else:
		return negate_using_add(result)

# UTILITY FUNCTIONS ---

# absolute value
def my_abs(a):
	if a >= 0:
		return a
	else:
		return negate_using_add(a)

# turns a positive number to negative using only 'addition'
# (not sure if it's legit: number -1 used somewhere)
def negate_using_add(a):
	neg = 0
	if a == 0:
		return 0
	elif a > 0:
		d = -1
	else:
		d = 1
	while a != 0:
		neg += d
		a += d
	return neg