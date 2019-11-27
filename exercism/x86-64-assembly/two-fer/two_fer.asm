	default	rel
	section	.text
	global	two_fer

%macro copy_str 1
%%loop:
	mov	cl, [%1] 		; Get 1 byte from the message to cl
	cmp	cl, 0 			; Check if the byte in cl is NULL
	je	%%end 			; Start copying the name if cl is NULL
	mov 	[rsi], cl 		; Insert in *buffer
	inc 	rsi 			; Move rsi to the next slot
	inc 	%1 			; Move message to the next byte
	jmp 	%%loop 			; Loop back to copy the next byte
%%end: 					; end label to finish the macro
%endmacro

two_fer:
	lea	r8, [msg_prefix]	; Get the address of the message prefix
	lea	r10, [msg_suffix]	; Get the address of the message suffix
	mov	r9, rdi			; Read the name arg from first argument
	cmp	r9, 0			; Check if the name is NULL
	jne	copy_prefix		; Start copying the prefix message if a name is given

set_default_name:
	lea	r9, [you]		; Get the default name address

copy_prefix:
	copy_str r8

copy_name:
	copy_str r9

copy_suffix:
	copy_str r10
	mov cl, [r10]
	mov [rsi], cl
	ret 				; End the program

	section .data
msg_prefix:	db "One for ", 0
msg_suffix:	db ", one for me.", 0
you:		db "you", 0

