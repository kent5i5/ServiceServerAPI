// $( document ).ready(function() {
//     var ctrlVideo = document.getElementsByClassName(".banner-video"); 
//     $('button').click(function(){
//       if ($('button').hasClass("active")){
        
//             ctrlVideo.play();
        
//         $('button').html("Pause");
//         $('button').toggleClass("active");
//       } else {
        
//             ctrlVideo.pause();
        
//         $('button').html("play");
//         $('button').toggleClass("active");
//       }
//     });
// });

const video = document.getElementById('video');
const videoControls = document.getElementById('video-controls');

const videoWorks = !!document.createElement('video').canPlayType;
const playButton = document.getElementsByClassName('.videobutton');
// if (videoWorks) {
//   video.controls = false;
//   videoControls.classList.remove('hidden');
// }
// function togglePlay() {
//   if (video.paused || video.ended) {
//     video.play();
//   } else {
//     video.pause();
//   }
// }


// updatePlayButton updates the playback icon and tooltip
// depending on the playback state
// function updatePlayButton() {
//   playbackIcons.forEach(icon => icon.classList.toggle('hidden'));

//   if (video.paused) {
//     playButton.setAttribute('data-title', 'Play (k)')
//   } else {
//     playButton.setAttribute('data-title', 'Pause (k)')
//   }
// }
// // Add eventlisteners here
// playButton.addEventListener('click', togglePlay);
// video.addEventListener('pause', updatePlayButton);
// video.addEventListener('play', updatePlayButton);
// function updatePlayButton() {
//   playbackIcons.forEach(icon => icon.classList.toggle('hidden'));

//   if (video.paused) {
//     playButton.setAttribute('data-title', 'Play (k)')
//   } else {
//     playButton.setAttribute('data-title', 'Pause (k)')
//   }
// }