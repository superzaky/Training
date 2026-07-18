module Main where
-- Multiples of 3 and 5
-- Problem 1
-- If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

-- Find the sum of all the multiples of 3 or 5 below 1000.

multiply :: Integer -> Integer -> Integer
multiply n multiplier =
  n*multiplier

calculateSumOfMultiplier :: Integer -> Integer
calculateSumOfMultiplier multiplier = 
  let n = 999 `div` multiplier 
  -- commented out 'q' here to prevent early rounding
      -- q = n `div` 2

  in (n * (multiplier + (multiply n multiplier))) `div` 2 -- we divide at the very end after we have multiplied everything together

main :: IO ()
main = do
  putStrLn "Hello, everybody!"
  let sum1 = calculateSumOfMultiplier 3
  let sum2 = calculateSumOfMultiplier 5
  let sum3 = calculateSumOfMultiplier 15
  let sum  = sum1 + sum2 - sum3
  print sum
  -- sum bevat de correcte waarde: 233168