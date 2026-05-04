module Main where

main = do
  putStrLn "Hello, everybody!2"
  putStrLn ("Please look at my favorite odd numbers: " ++ show (filter odd [10..20]))