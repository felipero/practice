
function is_prime(number, primes) {
  const m = Math.sqrt(number) + 1;
  for(let i = 0; i < primes.length && primes[i] < m; i++) {
    const prime = primes[i];

    if( number % prime === 0) {
      return false;
    }
  }

  return true
}


function nth_prime(n){

  const primes = [2, 3, 5];
  let [ candidate, count, step ] = [7, 3, 2];

  while(count < n) {
    if (is_prime(candidate, primes)) {
      primes.push(candidate);
      count += 1;
    }

    step = 6-step;
    candidate += step;
  }

  return primes.pop();
}


nth = 1000001;

const start = new Date().getTime();
console.log(nth_prime(nth));
console.log((new Date().getTime()-start)/1000 + ' seconds');

