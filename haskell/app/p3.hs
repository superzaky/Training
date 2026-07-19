module Main where
    -- Largest prime factor
    -- Problem 3
    -- The prime factors of 13195 are 5, 7, 13 and 29.

    -- What is the largest prime factor of the number 600851475143 ?

calculateMaxPrimeFactor :: Integer -> Integer -> Integer
calculateMaxPrimeFactor number i
  | number `mod` i /= 0 = number -- /= means not equal in Haskell
  | otherwise           = calculateMaxPrimeFactor (number `div` i) i

getFactorOrNumber :: Integer -> Integer -> Integer
getFactorOrNumber number factor =
  if number == 1
  then factor
  else number

getMaxPrimeFactorOf :: Integer -> Integer -> Integer
getMaxPrimeFactorOf number factor 
  -- 1. Base case: passed the square root
  | factor * factor > number = getFactorOrNumber number factor 
  
  -- 2. If it divides, and stripping the factor reduces the number to 1, we are done
  | number `mod` factor == 0 && calculateMaxPrimeFactor number factor == 1 = 
      getFactorOrNumber 1 factor
         
  -- 3. If it divides, but there is still a remainder left, keep looping with the next factor
  | number `mod` factor == 0 = 
      getMaxPrimeFactorOf (calculateMaxPrimeFactor number factor) (factor + 1)
         
  -- 4. If it doesn't divide at all, just move to the next factor
  | otherwise = getMaxPrimeFactorOf number (factor + 1)

main :: IO ()
main = do
  putStrLn "p3 program"
  print (getMaxPrimeFactorOf 600851475143 2) -- getMaxPrimeFactorOf should return 6857
  print (getMaxPrimeFactorOf 14 2)           -- getMaxPrimeFactorOf should return 7
  putStrLn "----------einde van programma-----------"