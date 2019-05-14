rep :: Int -> [Int] -> [Int]
rep n []  = []
rep n arr  = replicate n (head arr) ++ (rep n (tail arr))
-- concat (map (replicate 2) [1, 2, 3, 4])

-- This part handles the Input and Output and can be used as it is. Do not modify this part.
main :: IO ()
main = getContents >>=
       mapM_ print. (\(n:arr) -> rep n arr). map read. words
