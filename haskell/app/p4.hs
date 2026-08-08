module Main where
-- Problem 4 Largest palindrome product
-- A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

-- Find the largest palindrome made from the product of two 3-digit numbers.

-- Foolproof mathematical palindrome function
-- 1. `abs` guarantees we only work with positive numbers.
-- 2. `div` and `mod` are strictly positive for positive inputs.
-- 3. `Integer` guarantees NO overflow can ever turn numbers negative.
isPalindrome :: Int -> Bool
isPalindrome n = nVal == reverseInt nVal 0
  where
    nVal :: Integer
    nVal = abs (fromIntegral n)

    reverseInt :: Integer -> Integer -> Integer
    reverseInt 0 acc = acc -- Dit is de basisstap (base case). Als het invoergetal x is gereduceerd tot 0, is de functie klaar. Het resultaat in de accumulator (acc) wordt dan teruggegeven.
    reverseInt x acc = reverseInt (x `div` 10) (acc * 10 + x `mod` 10)

-- Explicit recursive loop so we don't rely on Haskell range syntax [h, h-11 ..]
checkPalindromes :: Int -> Int -> Int -> Int
checkPalindromes h i j = loopP h 0
  where
    loopP p maxSoFar
      | p <= i    = maxSoFar
      | otherwise = loopP (p - 11) (loopQ p j maxSoFar)

    loopQ p q maxSoFar
      | q <= i    = maxSoFar
      | prod > maxSoFar && isPalindrome prod = loopQ p (q - 1) prod
      | otherwise                            = loopQ p (q - 1) maxSoFar
      where
        prod = p * q

main :: IO ()
main = do
  putStrLn "p4 program"
  
  -- 2-digit test
  print (checkPalindromes 99 9 99)

  -- 3-digit main problemr
  print (checkPalindromes 990 99 999)
  
  putStrLn "----------einde van programma-----------"

