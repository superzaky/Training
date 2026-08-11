module Main where

-- Equivalent to static int[] numbers = {1, 2, 3, 4, ... 20}
numbers :: [Int]
numbers = [1..20]

-- Equivalent to getGcd(long p, long q)
getGcd :: Integral a => a -> a -> a
getGcd p q = 
    let loop currentP currentQ
            | currentQ == 0 = currentP
            | otherwise     = loop currentQ (currentP `mod` currentQ)
    in loop p q

-- Equivalent to getLcm(long p, long q)
getLcm :: Integral a => a -> a -> a
getLcm p q = (p * q) `div` getGcd p q

-- Equivalent to getLcmOfFirst2NumbersOrUpdateLcm(long lcmVal, int curr, int next)
getLcmOfFirst2NumbersOrUpdateLcm :: Integral a => a -> a -> a -> a
getLcmOfFirst2NumbersOrUpdateLcm lcmVal curr next =
    if lcmVal /= 1
        then getLcm lcmVal (getLcm curr next)
        else getLcm curr next

-- Equivalent to getLcmOfMultiple(int... numbers)
getLcmOfMultiple :: Integral a => [a] -> a
getLcmOfMultiple nums = loop 1 0
  where
    loop lcmVal i
        -- for (int i = 0; i < numbers.length - 1; i++)
        | i < length nums - 1 = 
            let curr = nums !! i
                next = nums !! (i + 1)
                updatedLcm = getLcmOfFirst2NumbersOrUpdateLcm lcmVal curr next
            in loop updatedLcm (i + 1)
        | otherwise = lcmVal

main :: IO ()
main = do
    print (getLcmOfMultiple numbers)
