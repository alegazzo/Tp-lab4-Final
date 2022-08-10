#CONSULTAS
select p.id as 'ID PAIS', p.nombre as 'PAIS', pr.id as 'ID PROVINCIA', pr.nombre as 'PROVINCIA', l.id as 'ID LOCALIDAD', l.nombre as 'LOCALIDAD'
from localidad as l
inner join provincia as pr on l.id_provincia = pr.id
inner join pais as p on pr.id_pais = p.id;

select a.id, a.legajo, a.nombre, a.apellido, a.fecha_nac as 'Nacimiento', a.adress as 'Direccion', p.nombre as 'Pais', pr.nombre as 'Provincia', l.nombre as 'Localidad', a.email, a.tel from alumno as a inner join localidad as l on l.id = a.id_localidad inner join provincia as pr on pr.id = a.id_provincia inner join pais as p on p.id = a.id_pais

select * from alumno where id = 6
update alumno set estado = 1 where id = 6

select * from tipo_usuario

select * from usuario



