import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users/users.service';


@Component({
    selector: 'app-counter',
    templateUrl: './counter.component.html',
    styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

    countActive = 0;
    countInactive = 0;

    constructor(private usersService: UsersService) {
        this.countActive = this.usersService.activeUsers.length;
        this.countInactive = this.usersService.inactiveUsers.length;
    }

    ngOnInit() {
        this.usersService.countActive.subscribe((count: number) => this.countActive = count);
        this.usersService.countInactive.subscribe((count: number) => this.countInactive = count);
    }
}
