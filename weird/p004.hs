reverseInt :: Int -> Int
reverseInt = read . reverse . show

p004 numDigits = maximum [x*y
		| x <- [(10^(numDigits-1)+1)..(10^numDigits-1)],
		  y <- [(10^(numDigits-1)+1)..(10^numDigits-1)],
		  reverseInt (x*y) == x*y]