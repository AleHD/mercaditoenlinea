import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from '../../../servicios/usuario.service';
import { Usuario } from '../../../interfaces/usuario';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.css']
})
export class IngresoComponent implements OnInit {
  ingresoForm: FormGroup;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit() {
    //Construimos el formulario ingresoForm.
    this.ingresoForm = this.formBuilder.group({
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: [
        '',
        [Validators.required, Validators.pattern('^[a-zA-Z]{16}')]
      ]
    });
  }

  //Devuleve el atributo correo de ingresoFrom.
  get correo() {
    return this.ingresoForm.get('correo');
  }

  //Devuleve el atributo constrasenia de ingresoFrom.
  get contrasenia() {
    return this.ingresoForm.get('contrasenia');
  }
}
