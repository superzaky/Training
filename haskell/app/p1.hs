module Main where


multiply :: Integer -> Integer -> Integer
multiply n multiplier =
  n*multiplier

calculateSumOfMultiplier :: Integer -> Float
calculateSumOfMultiplier multiplier = 
  let n = 999 / fromIntegral multiplier -- we use fromIntegral to cast an integer into a float so that the math works
      q = n / 2.0
  -- we use floor to cast a float into an integer
  in q * (fromIntegral multiplier + fromIntegral (multiply (floor n) multiplier)) 

main :: IO ()
main = do
  putStrLn "Hello, everybody!"
  let sum1 = calculateSumOfMultiplier 3
  let sum2 = calculateSumOfMultiplier 5
  let sum3 = calculateSumOfMultiplier 15
  let sum  = sum1 + sum2 - sum3
  print sum
  -- het juiste antwoord hoort dit te zijn: 233168
  putStrLn ("Please look at my favorite odd numbers: " ++ show (filter odd [10..20]))