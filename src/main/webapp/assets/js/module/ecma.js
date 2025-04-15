const clap = () => {
  console.log();
  console.log('👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏👏');
  console.log();
}

const odd = '홀수';
const even = '짝수';
const cdj = {
  username: '최동준',
  age: 15
}

let count = 0;
const counter = () => {
  count++;
  console.dir(count);
}

export {odd, even, cdj, counter}
export default clap;