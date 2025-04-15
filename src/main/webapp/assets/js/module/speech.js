const SpeechRecognition = window.SpeechRecognition
    || window.webkitSpeechRecognition;

class Speech {
  #isRecognize = true;
  #recognition;

  constructor(resultCallbackFnc) {
    this.#recognition = new SpeechRecognition();
    this.#recognition.continuous = true;

    this.#recognition.addEventListener('end', ev => {
      if (this.#isRecognize) {
        this.#recognition.start();
      }
    });

    this.#recognition.addEventListener('result', ev => {
      resultCallbackFnc(ev);
    })
  }

  recognize() {
    this.#isRecognize = true;
    this.#recognition.start();
  }

  stop() {
    this.#isRecognize = false;
    this.#recognition.stop();
  }

  speak(text) {
    const synth = window.speechSynthesis;
    const utterThis = new SpeechSynthesisUtterance(text);
    utterThis.pitch = 0.5;
    utterThis.rate = 1;
    synth.speak(utterThis); // 유효한 작업을 할 수 없기 때문에 EventListener 부분은 삭제
  }
}

export default Speech;