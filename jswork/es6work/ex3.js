//함수 파라미터에 기본값 가능하다
function func1(x,y=100,z=200){
    console.log(x,y,z);
}

func1(3,5,8);
func1(500);
func1(2,5);
func1(); //x정의안되어있음 undefined

function func2(a,b){
    return a+b;
}

func2(3,4);

console.log(func2(3,4));

let r1=func2(5,6);
console.log(r1); //11


let arr=[2,5,7];
let r2=func2(arr[0],arr[1]);
console.log(r2); // 7

// ... : es6에서 추가된기능 펼침연산자 라고 부른다
func1(...arr);
func1(arr[0],arr[1],arr[2]);

let r3=func2(...arr); //앞에 2개값 들어간다
console.log(r3); 

