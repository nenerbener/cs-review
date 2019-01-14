import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'ng2-demo4';

    evenNumbers: number[] = [];
    oddNumbers: number[] = [];

    onIntervalFired(firedEvent: number) {
        console.log('firedEvent is ' + firedEvent);
        if (firedEvent % 2 === 0) {
            this.evenNumbers.push(firedEvent);
        } else {
            this.oddNumbers.push(firedEvent);
        }
    }
}
