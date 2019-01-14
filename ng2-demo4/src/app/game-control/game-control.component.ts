import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-game-control',
    templateUrl: './game-control.component.html',
    styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {

    @Output() intervalFired = new EventEmitter<number>();
    interval;
    lastNumber = 0;

    constructor() { }

    ngOnInit() {
    }

    onStartGame() {
        // console.log('lastNumber before is ' + this.lastNumber);
        this.interval = setInterval(() => {
            this.intervalFired.emit(this.lastNumber + 1);
            this.lastNumber++;
        }, 1000);
        // console.log('in onStartGame(), interval is ' + this.interval + ' lastNumber is ' + this.lastNumber);
    }

    onPauseGame() {
        clearInterval(this.interval);
    }
}
