import { Component, OnInit } from '@angular/core';

@Component({
//   selector: '[app-servers]',
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

    allowNewServer = false;
    serverCreationStatus = 'No Server was created!';
    serverName = 'TestServer';
    serverCreated = false;
    servers = ['TestServer1', 'TestServer2'];
  constructor() {
     setTimeout(() => {
         this.allowNewServer = true;
     }, 2000);
   }

  ngOnInit() {
  }

  onCreateServer() {
    this.serverCreationStatus = 'Server was created! Server name is ' + this.serverName;
    this.serverCreated = true;
    console.log('This is written to the console');
    this.servers.push(this.serverName);
  }
 onUpdateServerName(event: Event) {
     console.log(event);
   this.serverName = (<HTMLInputElement>event.target).value;
 }
}
