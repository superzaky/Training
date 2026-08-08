module Main where

import Control.Monad (when)

-- Traceable mathematical palindrome check
isPalindrome :: Int -> IO Bool
isPalindrome n = do
  putStrLn $ "  [isPalindrome] Checking product: " ++ show n
  rev <- reverseInt nVal 0
  let matches = nVal == rev
  putStrLn $ "  [isPalindrome] Result: " ++ show nVal ++ " == " ++ show rev ++ " -> " ++ show matches
  return matches
  where
    nVal :: Integer
    nVal = abs (fromIntegral n)

    reverseInt :: Integer -> Integer -> IO Integer
    reverseInt 0 acc = do
      putStrLn $ "    [reverseInt] Base case reached (x = 0). Returning reversed value: " ++ show acc
      return acc
    reverseInt x acc = do
      let nextX   = x `div` 10
      let nextAcc = acc * 10 + x `mod` 10
      putStrLn $ "    [reverseInt] x = " ++ show x ++ " -> div 10 = " ++ show nextX ++ " | acc = " ++ show nextAcc
      reverseInt nextX nextAcc

-- Traceable recursive loop
checkPalindromes :: Int -> Int -> Int -> IO Int
checkPalindromes h i j = loopP h 0
  where
    loopP p maxSoFar
      | p <= i = do
          putStrLn $ "[loopP] Base case hit: p (" ++ show p ++ ") <= i (" ++ show i ++ "). Returning maxSoFar = " ++ show maxSoFar
          return maxSoFar
      | otherwise = do
          putStrLn $ "\n--- [loopP] Outer loop start: p = " ++ show p ++ " (maxSoFar = " ++ show maxSoFar ++ ") ---"
          newMax <- loopQ p j maxSoFar
          loopP (p - 11) newMax

    loopQ p q maxSoFar
      | q <= i = do
          putStrLn $ "[loopQ] Inner loop end: q (" ++ show q ++ ") <= i (" ++ show i ++ "). Yielding maxSoFar = " ++ show maxSoFar
          return maxSoFar
      | otherwise = do
          let prod = p * q
          putStrLn $ "[loopQ] Testing p = " ++ show p ++ ", q = " ++ show q ++ " => product = " ++ show prod
          
          if prod > maxSoFar
            then do
              putStrLn $ "  [loopQ] product (" ++ show prod ++ ") > maxSoFar (" ++ show maxSoFar ++ "). Checking palindrome..."
              isPal <- isPalindrome prod
              if isPal
                then do
                  putStrLn $ "  *** NEW MAX PALINDROME FOUND: " ++ show prod ++ " ***"
                  loopQ p (q - 1) prod
                else do
                  putStrLn $ "  [loopQ] Not a palindrome."
                  loopQ p (q - 1) maxSoFar
            else do
              putStrLn $ "  [loopQ] Skipping palindrome check (product " ++ show prod ++ " <= maxSoFar " ++ show maxSoFar ++ ")"
              loopQ p (q - 1) maxSoFar

main :: IO ()
main = do
  putStrLn "p4 program"
  
  putStrLn "\n=========================================="
  putStrLn "Running 2-digit test..."
  putStrLn "=========================================="
  result2 <- checkPalindromes 99 9 99
  putStrLn $ "\nFinal Result for 2-digit: " ++ show result2
  
  putStrLn "----------einde van programma-----------"
