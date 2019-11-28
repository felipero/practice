	default	rel
	section	.text
	global	two_fer

%macro copy_str 0 
%%loop:
	mov	cl, [r8] 		; Get 1 byte from the message to cl
	cmp	cl, 0 			; Check if the byte in cl is NULL
	je	%%end 			; Start copying the name if cl is NULL
	mov 	[rsi], cl 		; Insert in *buffer
	inc 	rsi 			; Move rsi to the next slot
	inc 	r8			; Move message to the next byte
	jmp 	%%loop 			; Loop back to copy the next byte
%%end: 					; end label to finish the macro
%endmacro

two_fer:

copy_prefix:
	lea 	r8, [msg_prefix]
	copy_str

name_or_default:
	mov	r8, rdi			; Read the name arg from first argument
	cmp	r8, 0			; Check if the name is NULL
	jne	copy_name		; Start copying the prefix message if a name is given
	lea	r8, [you]		; Get the default name address

copy_name:
	copy_str

copy_suffix:
	lea 	r8, [msg_suffix]
	copy_str
	mov [rsi], byte 0
	ret 				; End the program

	section .data
msg_prefix:	db "One for ", 0
msg_suffix:	db ", one for me.", 0
you:		db "you", 0

