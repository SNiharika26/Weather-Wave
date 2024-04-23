import { Component, OnInit } from '@angular/core';
import { trigger, transition, style, animate, keyframes } from '@angular/animations';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
  animations: [
    // Define fade-in animation for the container
    trigger('fadeInOut', [
        transition(':enter', [
            style({ opacity: 0 }),
            animate('1s ease-in', style({ opacity: 1 }))
        ])
    ]),
    
    // Define snowfall animation
    trigger('snowFall', [
        transition('* => *', [
            animate(
                '10s linear',
                keyframes([
                    style({ top: '-50px', offset: 0 }),
                    style({ top: '100%', offset: 1 })
                ])
            )
        ])
    ])
  ]
})
export class WelcomeComponent implements OnInit {
    snowflakes: any[] = [];

    constructor(private router: Router) {}

    ngOnInit() {
        this.createSnowflakes();
    }

    navigateToWeather() {
        // Navigate to the weather route
        this.router.navigate(['/weather']);
    }

    createSnowflakes() {
        const snowflakeCount = 50; // Number of snowflakes
        for (let i = 0; i < snowflakeCount; i++) {
            const snowflake = {
                style: {
                    left: `${Math.random() * 100}vw`, // Random horizontal position
                    animationDelay: `${Math.random() * 5}s`, // Random delay before falling
                },
                animation: 'falling'
            };
            this.snowflakes.push(snowflake);
        }
    }
}
