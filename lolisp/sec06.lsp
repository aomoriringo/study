(defun say-hello ()
  (print "Please type your name:")
  (let ((name (read)))
    (print "Nice to meet you, ")
    (print name)))

(defun add-five ()
  (print "Please enter a number:")
  (let ((num (read)))
    (print "When I add five I get")
    (print (+ num 5))))

(defun say-hello2 ()
  (princ "Please type your name:")
  (let ((name (read-line)))
    (princ "Nice to meet you, ")
    (princ name)))

(defun game-repl ()
  (loop (print (eval (read)))))

(defun game-repl2 ()
  (let ((cmd (game-read)))
    (unless (eq (car cmd) 'quit)
      (game-print (game-eval cmd))
      (game-repl2))))

(defun game-read ()
  (let ((cmd (read-from-string
	      (concatenate 'string "(" (read-line) ")"))))
    (flet ((quote-it (x)
		     (list 'quote x)))
      (cons (car cmd) (mapcar #'quote-it (cdr cmd))))))

(defparameter *allowed-commands* '(look walk pickup inventory))

(defun game-eval (sexp)
  (if (member (car sexp) *allowed-commands*)
      (eval sexp)
    '(i do not know that command.)))

(defun tweak-text (lst caps lit)
  (when lst
    (let ((item (car lst))
	  (rest (cdr lst)))
      (cond ((eql item #\space) (cons item (tweak-text rest caps lit)))
	    ((member item '(#\! #\? #\.)) (cons item (tweak-text rest t lit)))
	    ((eql item #\") (tweak-text rest caps (not lit)))
	    (lit (cons item (tweak-text rest nil lit)))
	    (caps (cons (char-upcase item) (tweak-text rest nil lit)))
	    (t (cons (char-downcase item) (tweak-text rest nil nil)))))))

(defun game-print (lst)
  (princ (coerce (tweak-text (coerce (string-trim "() "
						  (prin1-to-string lst))
				     'list)
			     t
			     nil)
		 'string))
  (fresh-line))

