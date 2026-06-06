module Main where

multiply :: Integer -> Integer -> Integer
multiply n multiplier =
  n*multiplier

calculateSumOfMultiplier :: Integer -> Integer
calculateSumOfMultiplier multiplier = 
  let n = 999 `div` multiplier 
      q = n `div` 2

  in q * (multiplier + (multiply n multiplier)) 

main :: IO ()
main = do
  putStrLn "Hello, everybody!"
  let sum1 = calculateSumOfMultiplier 3
  let sum2 = calculateSumOfMultiplier 5
  let sum3 = calculateSumOfMultiplier 15
  let sum  = sum1 + sum2 - sum3
  print sum
  -- sum bevat 232167, maar het juiste antwoord hoort dit te zijn: 233168