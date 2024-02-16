/* 눈 내리는 효과 */
$(document).ready(function() {
      var snowCount = 50; // 원하는 눈의 개수를 설정

      for (var i = 0; i < snowCount; i++) {
        $('<div class="snow"></div>').appendTo('main');
      }

      function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
          color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
      }

      var snowElements = document.getElementsByClassName('snow');
      for (var i = 0; i < snowElements.length; i++) {
        var snowElement = snowElements[i];
        snowElement.style.setProperty('--snow-color', getRandomColor());
      }
});

