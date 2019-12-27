section .text
global leap_year

%macro divide_by 1
	xor	rdx, rdx
	mov	rax, rdi
	mov	r8, %1
	div	r8
	test	rdx, rdx
%endmacro

leap_year:

	divide_by 4
	jne	return_false	; Not divisible by 4

	divide_by 100
	jne	return_true	; Not divisible by 100

	divide_by 400
	je	return_true	; Divisible by 400

return_false:
	xor	rax, rax
	ret

return_true:
	mov 	rax, 1
	ret

