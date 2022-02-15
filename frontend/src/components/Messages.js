import React from 'react'

const Messages = ({ messages }) => {
  return (
    <ul className='list-group list-group-flush'>
      {messages.map((message, index) => (
        <li className='list-group-item'> {message.name} says: {message.message}</li>
      ))}
    </ul>
  )
}

export default Messages