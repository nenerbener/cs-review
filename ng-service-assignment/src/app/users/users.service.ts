import { Injectable, EventEmitter, OnInit } from '@angular/core';

@Injectable({providedIn: 'root'})
export class UsersService implements OnInit {

    activeUsers = ['Max', 'Anna'];
    inactiveUsers = ['Chris', 'Manu'];

    countActive = new EventEmitter<number>();
    countInactive = new EventEmitter<number>();

    constructor() {
    }
    ngOnInit() {
        this.countActive.emit(this.activeUsers.length);
        this.countInactive.emit(this.inactiveUsers.length);
    }

    onSetToInactive(id: number) {
        this.inactiveUsers.push(this.activeUsers[id]);
        this.activeUsers.splice(id, 1);
        this.countActive.emit(this.activeUsers.length);
        this.countInactive.emit(this.inactiveUsers.length);
    }

    onSetToActive(id: number) {
        this.activeUsers.push(this.inactiveUsers[id]);
        this.inactiveUsers.splice(id, 1);
        this.countActive.emit(this.activeUsers.length);
        this.countInactive.emit(this.inactiveUsers.length);
    }
}