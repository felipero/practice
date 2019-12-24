section .text
global leap_year

%macro divide_by 1
	mov	rax, rdi
	mov	rbx, %1
	div	rbx
	cmp	rdx, 0
%endmacro

leap_year:

div_4:
	divide_by 4
	jne	return_false  ; Not divisible by 4

div_100:
	divide_by 100
	jne	return_true  ; Not divisible by 100

div_400:
	divide_by 400
	je	return_true

return_false:
	mov	rax, 0
	ret

return_true:
	mov 	rax, 1
	ret

