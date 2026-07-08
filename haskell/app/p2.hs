module Main where

-- We use a helper function to keep track of the current terms as we loop
calculateSum :: Integer -> Integer
calculateSum limit = go 1 2 0
  where
    -- we defined go as our helper function
    go oddValuedTerm evenValuedTerm currentSum
      -- If evenValuedTerm is greater than or equal to limit, then return the currentSum
      | evenValuedTerm >= limit = currentSum
      | otherwise = 
          let d = oddValuedTerm + (evenValuedTerm * 2) -- writing evenValuedTerm << 0x01 in Java was just a low-level, hyper-optimized way of writing evenValuedTerm * 2
              nextEven = d + oddValuedTerm + evenValuedTerm
              nextOdd  = d
          in go nextOdd nextEven (currentSum + evenValuedTerm)

main :: IO ()
main = do
  putStrLn "p2 program"
  -- Pass 4000000 as the limit to the function
  print (calculateSum 4000000) -- calculateSum 4000000 outputs 4613732, which is the correct answer to this question (problem 2 from Project Euler)