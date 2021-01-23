//This Component is role-based. But authorization will be processed by back-end.
//We only need to call UserService method to get protected resources from back-end.
import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  content = '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getCustomerContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
