module Main where

calculateSumOfMultiplier::Integer -> Float
calculateSumOfMultiplier multiplier = 
  let n  = 999 / multiplier
  Num q = n / 2.0

main = do
  putStrLn "Hello, everybody!"
  putStrLn ("Please look at my favorite odd numbers: " ++ show (filter odd [10..20]))