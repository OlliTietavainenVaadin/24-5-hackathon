import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { useSignal } from '@vaadin/hilla-react-signals';
import { Button } from '@vaadin/react-components/Button.js';
import { Notification } from '@vaadin/react-components/Notification.js';
import { TextField } from '@vaadin/react-components/TextField.js';
import { HelloWorldService } from 'Frontend/generated/endpoints.js';
import { PersonService} from "Frontend/generated/endpoints.js";

export const config: ViewConfig = {
  menu: { order: 2, icon: 'line-awesome/svg/globe-solid.svg' },
  title: 'Hilla World',
  rolesAllowed: ['ADMIN'],
};

const person = PersonService.getPersonSignal({defaultValue: {
        name:'',
        birthYear:0
    }});

export default function HillaWorldView() {
  const name = useSignal('');


  return (
    <>
      <section className="flex p-m gap-m items-end">
        <TextField
          label="Your name"
          onValueChanged={(e) => {
            name.value = e.detail.value;
          }}
        />
        <Button
          onClick={async () => {
            const serverResponse = await HelloWorldService.sayHello(name.value);
            Notification.show(serverResponse);
          }}
        >
          Say hello
        </Button>
          <TextField label="Name" value={person.value.name}
                     onValueChanged={(e) => {
                         person.replace(person.value, {
                             ...person.value,
                             name: e.detail.value
                         })
                     }} />

      </section>
    </>
  );
}
