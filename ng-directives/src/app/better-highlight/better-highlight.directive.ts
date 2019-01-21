import { Directive, Renderer2, OnInit, ElementRef, HostListener, HostBinding } from '@angular/core';

@Directive({
    selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective implements OnInit {

    @HostBinding('style.backgroundColor') backgroundColor = 'transparent';
    constructor(private elRef: ElementRef, private renderer: Renderer2) { }

    ngOnInit() {
        // this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'blue');
    }

    @HostListener('mouseenter') MouseOver(event: Event) {
        // this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'blue');
        this.backgroundColor = 'blue';
    }

    @HostListener('mouseleave') MouseLeave(event: Event) {
        this.backgroundColor = 'transparent';
        // this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'transparent');
    }
}
