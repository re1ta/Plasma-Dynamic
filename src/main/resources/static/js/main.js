let buttonMore = document.querySelector('.equipment__block__button_1')
let buttonBack = document.querySelector('.equipment__block__button_2')
let case1 = document.querySelector('.examples__example_1')
let case2 = document.querySelector('.examples__example_2')

console.log(buttonMore);
console.log(buttonBack);

buttonMore.onclick = function() {
    document.querySelector('.equipment__block_1').style.display = 'none';
    document.querySelector('.equipment__block_2').style.display = 'grid';
}

buttonBack.onclick = function() {
    document.querySelector('.equipment__block_2').style.display = 'none';
    document.querySelector('.equipment__block_1').style.display = 'grid';
}


case1.onclick = function() {
    case1.style.display = 'none';
    case2.style.display = 'grid';
}

case2.onclick = function() {
    case2.style.display = 'none';
    case1.style.display = 'grid';
}